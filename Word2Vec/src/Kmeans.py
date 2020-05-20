from gensim.models import KeyedVectors
model = KeyedVectors.load_word2vec_format("word2vec.txt") # 모델 로드

from nltk.cluster import KMeansClusterer
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt
import nltk
from sklearn import cluster
from sklearn import metrics

X = model[model.vocab]

NUM_CLUSTERS = 4

kmeans = cluster.KMeans(n_clusters=NUM_CLUSTERS)
kmeans.fit(X)

labels = kmeans.labels_
centroids = kmeans.cluster_centers_
'''
print ("Cluster id labels for inputted data")
print (labels)
print ("Centroids data")
print (centroids[0])
print (centroids[1])
print (centroids[2])
print (centroids[3])


print ("Score (Opposite of the value of X on the K-means objective which is Sum of distances of samples to their closest cluster center):")
print (kmeans.score(X))
'''

# silhouette_score = metrics.silhouette_score(X, labels, metric='euclidean')

# print ("Silhouette_score: ")
# print (silhouette_score)

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


# 21613 총 단어 수
def word_match(V, Key_list):
    for i in range(21613):
        if all(model[Key_list[i]] == V):
            return Key_list[i]
            break

'''
cos_sim(centroids[0], X[4])
print(nearest(centroids[0], X))
print(centroids[0])
print(nearest(centroids[1], X))
print(centroids[1])
print(nearest(centroids[2], X))
print(centroids[2])
print(nearest(centroids[3], X))
print(centroids[3])
print(cos_sim(centroids[0], nearest(centroids[0], X)))
print(cos_sim(centroids[1], nearest(centroids[1], X)))
print(cos_sim(centroids[2], nearest(centroids[2], X)))
print(cos_sim(centroids[3], nearest(centroids[3], X)))
'''

key_list = list(model.wv.vocab.keys())

word_list = []
word_list.append(word_match(nearest(centroids[0], X), key_list))
word_list.append(word_match(nearest(centroids[1], X), key_list))
word_list.append(word_match(nearest(centroids[2], X), key_list))
word_list.append(word_match(nearest(centroids[3], X), key_list))

print(word_list)

f = open("초기단어test.txt", 'w')
recommend_list = []  # 추천단어 list

for i in (word_list):
    recommend_list.append(i.lower())
    model_result = model.most_similar(i.lower(), topn=50)
    for j, k in model_result:
        recommend_list.append(j)

recommend_set = set(recommend_list)
recommend_list = list(recommend_set)

for i in (recommend_list):
    f.write(i)
    f.write(' ')

print(len(recommend_list))

f.close()