from gensim.models import KeyedVectors

loaded_model = KeyedVectors.load_word2vec_format("eng_w2v_5.txt") # 모델 로드
key_list5 = list(loaded_model.wv.vocab.keys())
len(key_list5)

loaded_model = KeyedVectors.load_word2vec_format("eng_w2v_7.txt") # 모델 로드
key_list7 = list(loaded_model.wv.vocab.keys())
len(key_list7)

loaded_model = KeyedVectors.load_word2vec_format("eng_w2v_11.txt") # 모델 로드
key_list11 = list(loaded_model.wv.vocab.keys())
len(key_list11)

loaded_model = KeyedVectors.load_word2vec_format("eng_w2v_20.txt") # 모델 로드
key_list20 = list(loaded_model.wv.vocab.keys())
len(key_list20)

loaded_model = KeyedVectors.load_word2vec_format("eng_w2v_50.txt") # 모델 로드
key_list50 = list(loaded_model.wv.vocab.keys())
len(key_list50)

loaded_model = KeyedVectors.load_word2vec_format("eng_w2v_500.txt") # 모델 로드
key_list500 = list(loaded_model.wv.vocab.keys())
len(key_list500)            #level 0

key_list5_7 = [x for x in key_list5 if x not in key_list7]
print(len(key_list5_7))     #level 5
key_list7_11 = [x for x in key_list7 if x not in key_list11]
print(len(key_list7_11))    #level 4
key_list11_20 = [x for x in key_list11 if x not in key_list20]
print(len(key_list11_20))   #level 3
key_list20_50 = [x for x in key_list20 if x not in key_list50]
print(len(key_list20_50))   #level 2
key_list50_500 = [x for x in key_list50 if x not in key_list500]
print(len(key_list50_500))  #level 1

f = open("level5.txt", 'w')
g = open("level4.txt", 'w')
h = open("level3.txt", 'w')
j = open("level2.txt", 'w')
k = open("level1.txt", 'w')

for i in key_list5_7:
    if len(i) > 4:
        f.write(i)
        f.write(' ')

for i in key_list7_11:
    if len(i) > 4:
        g.write(i)
        g.write(' ')

for i in key_list11_20:
    if len(i) > 4:
        h.write(i)
        h.write(' ')

for i in key_list20_50:
    if len(i) > 4:
        j.write(i)
        j.write(' ')

for i in key_list50_500:
    if len(i) > 4:
        k.write(i)
        k.write(' ')

f.close()
g.close()
h.close()
j.close()
k.close()