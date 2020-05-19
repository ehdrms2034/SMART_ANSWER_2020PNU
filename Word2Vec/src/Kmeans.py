from gensim.models import KeyedVectors
model = KeyedVectors.load_word2vec_format("word2vec.txt") # 모델 로드

X = model[model.vocab]

from nltk.cluster import KMeansClusterer
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt
import nltk

NUM_CLUSTERS=4

'''
def elbow(X):
    sse = []
    for i in range(1, 11):
        km = KMeans(n_clusters=i, init='k-means++', random_state=0)
        km.fit(X)
        sse.append(km.inertia_)

    plt.plot(range(1, 11), sse, marker='o')
    plt.xlabel('Num of Cluster')
    plt.ylabel('SSE')
    plt.show()

elbow(X)
# 결과에 따라 4개의 Cluster로 분류
'''

from sklearn import cluster
from sklearn import metrics

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

from sklearn.manifold import TSNE
import matplotlib.font_manager as fm
import matplotlib.pyplot as plt
import matplotlib

path_gothic = "C:\\Users\\user\\Downloads\\Gaegu\\Gaegu-Regular.ttf"
prop = fm.FontProperties(fname=path_gothic)
matplotlib.rcParams["axes.unicode_minus"] = False

vocab = list(model.wv.vocab)

tsne = TSNE(n_components=2)
X_tsne = tsne.fit_transform(X)

import pandas as pd

df = pd.DataFrame(X_tsne, index=vocab, columns=["x", "y"])

'''
%matplotlib inline

fig = plt.figure()
fig.set_size_inches(40, 20)
ax = fig.add_subplot(1, 1, 1)
ax.scatter(df["x"], df["y"])

for word, pos in list(df.iterrows()):
    ax.annotate(word, pos, fontsize=12, fontproperties=prop)
plt.show()
'''

print (centroids[0])
print (centroids[1])
print (centroids[2])
print (centroids[3])