from gensim.models import KeyedVectors
model = KeyedVectors.load_word2vec_format("word2vec.txt")

from sklearn import cluster
from sklearn import metrics

X = model[model.vocab]

NUM_CLUSTERS = 4

kmeans = cluster.KMeans(n_clusters=NUM_CLUSTERS)
kmeans.fit(X)

labels = kmeans.labels_
centroids = kmeans.cluster_centers_

'''
print("Cluster id labels for inputted data")
print(labels)
print("Centroids data")
print(centroids[0])
print(centroids[1])
print(centroids[2])
print(centroids[3])

print(
    "Score (Opposite of the value of X on the K-means objective which is Sum of distances of samples to their closest cluster center):")
print(kmeans.score(X))
'''
silhouette_score = metrics.silhouette_score(X, labels, metric='euclidean')

print("Silhouette_score: ")
print(silhouette_score)