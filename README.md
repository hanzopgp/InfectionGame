# Jeu d'infection IA

## Table des matières
1. [Auteurs](#projet-conçu)
2. [Fonctionnement](#fonctionnement)
3. [Regles du jeu](#regles-du-jeu)
4. [Liens utiles](#liens-utiles)

## Projet conçu par :

- Enzo Durand : 21510242, groupe 2A L2 informatique
- Thomas Gignoux : 21805697 groupe 2A L2 informatique

## Fonctionnement :

- Dans le terminal, se placer dans le repertoire du projet
- Compiler les fichiers .java avec "javac -d build */*.java"
- Lancer le fichier executable Main avec "java -cp build/ projet1_7.Main ... ... ... ... ..."
- Après Main, il faut mettre les arguments :
	- Argument 1 - int : Nombre de lignes
	- Argument 2 - int : Nombre de colonnes
	- Argument 3 - string : type de joueur 1 ( human / random / minmax )
	- Argument 4 - string : type de joueur 2 ( human / random / minmax )
	- Argument 5 - int : nombre de coups d'avance pour le joueur 1
- Si vous choisissez un ou deux joueurs minmax, il faut maintenant choisir ces parametres :
	- Parametre 1 - int : Profondeur joueur minmax 1
	- Parametre 2 - int : Profondeur joueur minmax 2
	- Parametre 3 - booleen : Utilisation AlphaBeta ? ( 0 / 1 )
- Puis chosir si vous voulez une pause entre les tours :
	- Parametre 4 - booleen : Pause entre les tours ? ( 0 / 1 )

## Regles du jeu :
	
- Si vous avez choisit human alors quand c'est votre tour vous devez choisir votre coup
- Vous avez l'affichage de la grille ainsi que la liste des coups valides
- Le programme demande successivement un x, un y, un type de move

## Liens utiles :

- https://en.wikipedia.org/wiki/Minimax
