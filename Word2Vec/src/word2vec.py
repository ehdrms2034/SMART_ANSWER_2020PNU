from gensim.models import KeyedVectors
model = KeyedVectors.load_word2vec_format("word2vec.txt")

import random

f = open("틀린단어.txt", 'r')
g = open("추천단어.txt", 'w')

word_list = f.readline().split()  # 틀린 단어 list
recommend_list = []  # 틀린 단어로 만든 추천 단어 list

# 틀린단어로 만든 추천단어
for i in (word_list):
    recommend_list.append(i.lower())
    model_result = embedding_model.most_similar(i.lower(), topn=40)
    for j, k in model_result:
        recommend_list.append(j)

recommend_set = set(recommend_list)
recommend_list = list(recommend_set)

if len(recommend_list) > 40:
    recommend_list = random.sample(recommend_list, 40)

level = 4

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

recommend_list = recommend_list + random.sample(level_list, 40) + word_list

recommend_set = set(recommend_list)
recommend_list = list(recommend_set)

for i in (recommend_list):
    g.write(i)
    g.write(' ')

f.close()
g.close()
h.close()
