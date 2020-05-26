from gensim.models import KeyedVectors
embedding_model = KeyedVectors.load_word2vec_format("word2vec.txt") # 모델 로드

f = open("틀린단어.txt", 'r')
g = open("추천단어.txt", 'w')

word_list = f.readline().split()
write_list=[]

for i in (word_list):
    model_result = embedding_model.most_similar(i.lower(),topn=50)
    for j, k in model_result:
        write_list.append(j)

write_list = list(set(write_list))
               
for i in (write_list):
    print(i)
    g.write(i)
    g.write(' ')

f.close()
g.close()
