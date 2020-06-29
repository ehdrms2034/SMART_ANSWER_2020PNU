from gensim.models import KeyedVectors
import random
import requests
import json

model = KeyedVectors.load_word2vec_format("word2vec.txt")

name = "tjr99382"
date = "2020-06-23"
data = {
    "id": name,
    "date": date
}
r = requests.post('http://54.180.175.238:8080/api/wrong/getbyidanddate', json=data)
print(r.text)
json_data = json.loads(r.text)


# 틀린 단어
wrongWord = json_data['data']['my_word']

test_list = []  # 틀린 단어로 만든 추천 단어 list

# 틀린 단어로 만든 추천 단어
for i in (json_data['data']['my_word']):
    model_result = model.most_similar(i.lower(), topn=40)
    for j, k in model_result:
        if len(j) > 4:
            test_list.append(j)

test_set = set(test_list)
test_list = list(test_set)

if len(test_list) > 40:
    test_list = random.sample(test_list, 40)

# static 단어
level = 1

if level == 1:
    h = open("level1.txt", 'r')
    level_list = h.readline().split()
elif level == 2:
    h = open("level2.txt", 'r')
    level_list = h.readline().split()
elif level == 3:
    h = open("level3.txt", 'r')
    level_list = h.readline().split()
elif level == 4:
    h = open("level4.txt", 'r')
    level_list = h.readline().split()
elif level == 5:
    h = open("level5.txt", 'r')
    level_list = h.readline().split()

random_list = random.sample(level_list, 40)
test_list = test_list + wrongWord + random_list

test_set = set(test_list)
test_list = list(test_set)

#print(test_list)
#print(wrongWord)

data = {
    "date": date,
    "owner": name,
    "testWord": test_list
}
#print(len(data["testWord"]))

r = requests.post('http://54.180.175.238:8080/api/test/inputTestWord', json=data)
print(r.text)

h.close()
