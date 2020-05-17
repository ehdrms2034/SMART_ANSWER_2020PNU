from gensim.models import KeyedVectors
model = KeyedVectors.load_word2vec_format("word2vec.txt") # 모델 로드

X = model[model.vocab]

from nltk.cluster import KMeansClusterer
import nltk
NUM_CLUSTERS=10
kclusterer = KMeansClusterer(NUM_CLUSTERS, distance=nltk.cluster.util.cosine_distance, repeats=25)
assigned_clusters = kclusterer.cluster(X, assign_clusters=True)

# 단어와 클러스터 출력
words = list(model.vocab)
for i, word in enumerate(words):
    print (word + ":" + str(assigned_clusters[i]))

from sklearn import cluster
from sklearn import metrics

#중심 좌표 출력
kmeans = cluster.KMeans(n_clusters=NUM_CLUSTERS)
kmeans.fit(X)

labels = kmeans.labels_
centroids = kmeans.cluster_centers_

print("Cluster id labels for inputted data")
print(labels)
print("Centroids data")
print(centroids)

print(
    "Score (Opposite of the value of X on the K-means objective which is Sum of distances of samples to their closest cluster center):")
print(kmeans.score(X))

silhouette_score = metrics.silhouette_score(X, labels, metric='euclidean')

print("Silhouette_score: ")
print(silhouette_score)