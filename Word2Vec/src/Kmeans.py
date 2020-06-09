from gensim.models import KeyedVectors
model = KeyedVectors.load_word2vec_format("word2vec.txt")

from sklearn import cluster

X = model[model.vocab]

NUM_CLUSTERS = 4

kmeans = cluster.KMeans(n_clusters=NUM_CLUSTERS)
kmeans.fit(X)

labels = kmeans.labels_
centroids = kmeans.cluster_centers_

from numpy import dot
from numpy.linalg import norm
import numpy as np


def cos_sim(A, B):
    return dot(A, B) / (norm(A) * norm(B))


def nearest(C, X):
    near = X[0]
    for x in X:
        if cos_sim(C, x) > cos_sim(C, near):
            near = x
    return near


# 21613 total words
def word_match(V, Key_list):
    for i in range(21613):
        if all(model[Key_list[i]] == V):
            return Key_list[i]
            break

key_list = list(model.wv.vocab.keys())

word_list = []
word_list.append(word_match(nearest(centroids[0], X), key_list))
word_list.append(word_match(nearest(centroids[1], X), key_list))
word_list.append(word_match(nearest(centroids[2], X), key_list))
word_list.append(word_match(nearest(centroids[3], X), key_list))

print(word_list)

f = open("initialTest.txt", 'w')
g = open("centroids.txt", 'w')

for i in word_list:
    g.write(i)
    g.write(' ')

recommend_list = []  # 추천단어 list

for i in (word_list):
    recommend_list.append(i.lower())
    model_result = model.most_similar(i.lower(), topn=50)
    for j, k in model_result:
        if len(i) > 4:
            recommend_list.append(j)

recommend_set = set(recommend_list)
recommend_list = list(recommend_set)

for i in (recommend_list):
    f.write(i)
    f.write(' ')

print(len(recommend_list))

f.close()
g.close()