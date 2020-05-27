from gensim.models import KeyedVectors
embedding_model = KeyedVectors.load_word2vec_format("word2vec.txt") # 모델 로드

dontKnow = input().lower()

model_result = embedding_model.most_similar(dontKnow,topn=50)
result_modified = []
for i, j in model_result:
    result_modified.append(i) #뒤쪽 벡터는 출력안함, 앞만 계속 바뀜
print(result_modified)


#print(model_result)
