# JudgyAI
**JudgyAI** est une application qui sert à classifier les tweets d’après un hashtag précis. Comme de nos jours les évènements ont souvent des hashtags précis, ce serait très utile pour conférences, séminaires, concerts, festivals, etc. 

## Auteur
*lmameri* (moi-même)

## Fonctionnement
 On lance le programme et apparait la fenêtre de l'application. On tape le mot cherché dans la case indiquée (il ne faut pas inclure le hashtag, c’est déjà fait) et on clique sur le bouton *Run*. On patiente quelques secondes et dans la case du bas s’affiche les résultats globaux, c’est –à-dire si les avis sont positifs ou négatifs. Un fichier créé à la racine contient les résultats détaillés. Seuls les tweets en anglais sont retenus. 
 **Attention : Il est important pour que cela marche d’être connecté à internet et d'avoir installé toutes les dépendances citées dans la catégorie plus bas**

Voici un exemple d'utilisation en 3 étapes :

- Étape 1 : On lance le programme et on devrait avoir l'interface graphique suivante qui s'affiche 
![Etape 1](https://github.com/lmameri/JudgyAI/blob/master/step1.PNG)

- Étape 2 : On choisit notre hashtag, shopify dans le cas de cet exemple et on clique sur *Run*, le résultat global devrait s'afficher dans la fenêtre tel que ci-dessous
![Etape 2](https://github.com/lmameri/JudgyAI/blob/master/step2.PNG)

- Étape 3 : On peut consulter le fichier resultats.txt pour plus de détails; la polarité du tweet est spécifiée par 'positif' ou 'negatif'
![Etape 3](https://github.com/lmameri/JudgyAI/blob/master/step3.PNG)

## Plateformes supportées

J'ai testé ce programme sur Windows 10 Pro Version 10.0.17134

## Dépendances
- [weka](https://www.cs.waikato.ac.nz/ml/index.html) ! Contient les algorithmes de Machine Learning et plus précisement le classifier  Naive Bayes Mutinomial Text
- [twitter4j](http://twitter4j.org/en/) ! Exploite l'API de twitter pour extraire les tweets
- [jackson](https://github.com/FasterXML/jackson) ! Traite les fichiers JSON (tweets, résultats, training)
- [emoji4j](https://github.com/kcthota/emoji4j) ! Remplace les smileys dans les tweets par un adjectif les décrivant
- [cglib-nodep](https://github.com/cglib/cglib/wiki) ! Utilisée par emoji4j
- [harmcrest](http://hamcrest.org/JavaHamcrest/) ! Utilisée par emoji4j
- [lambdaj](https://code.google.com/archive/p/lambdaj/) ! Utilisée par emoji4j


## État du programme

 Le TP ne prend en compte qu’une cinquantaine de tweets (les derniers publiés). Il pourrait prendre plusieurs milliers, cependant on a un nombre limité de requête toutes les 15mins via l'API de twitter. J’ai préféré limiter à 50 tweets pour relancer plusieurs fois le programme sans avoir à attendre. 




