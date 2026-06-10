# pixel_tracer

Projet de tracé de formes en mode texte, avec deux implémentations : C et Java.

## À propos du projet

Ce dépôt contient deux versions du même concept :

- `pixel_tracer_c/` : implémentation en C avec un interface en ligne de commande et rendu ASCII.
- `pixel_tracer_java/` : implémentation orientée objet en Java, également interactive.

L’objectif est de dessiner des formes géométriques sur une grille de caractères à partir de commandes utilisateur.

---

# Partie C

La version C est une application console qui utilise `readline` pour la saisie interactive et dessine les formes sur une grille de points.

## Ce que fait le code C

- initialise une grille de caractères.
- lit des commandes utilisateur.
- crée et gère des formes : point, ligne, carré, rectangle, cercle, polygone, courbe.
- gère des calques et des éléments via des commandes de gestion.
- affiche le résultat dans la console avec des caractères ASCII.

## Installation

```bash
sudo apt install build-essential
sudo apt install make
sudo apt install libreadline-dev
```

## Compilation

```bash
cd /home/etudiant/Documents/pixel_tracer/pixel_tracer/src
make
```

Le `Makefile` compile les fichiers C et produit un exécutable.

## Compilation manuelle

Si nécessaire, voici les commandes utilisées pour compiler manuellement :

```bash
gcc -o area.lin.o -c area.c
gcc -o command.lin.o -c command.c
gcc -o id.lin.o -c id.c
gcc -o layers.lin.o -c layers.c
gcc -o list.lin.o -c list.c
gcc -o main.lin.o -c main.c
gcc -o pixel.lin.o -c pixel.c
gcc -o pixel_tracer.lin.o -c pixel_tracer.c
gcc -o render.lin.o -c render.c
gcc -o shape.lin.o -c shape.c
gcc -o draw area.lin.o command.lin.o id.lin.o layers.lin.o list.lin.o main.lin.o pixel.lin.o pixel_tracer.lin.o render.lin.o shape.lin.o -lreadline
```

## Exécution

```bash
./draw
```

## Ce que vous devez voir

Le programme affiche une grille de points et attend des commandes :

```
................................................................................
................................................................................
................................................................................
... (grille de points) ...

~> help
```

## Commandes C disponibles

- `clear` : efface l’écran.
- `exit` : quitte le programme.
- `help` : affiche l’aide détaillée.
- `plot` : dessine l’écran.
- `point px py` : crée un point à `(px, py)`.
- `line x1 y1 x2 y2` : trace une ligne.
- `square x1 y1 l` : trace un carré de côté `l`.
- `rectangle x1 y1 w h` : trace un rectangle de largeur `w` et hauteur `h`.
- `circle x y r` : trace un cercle de centre `(x, y)` et rayon `r`.
- `polygon x1 y1 x2 y2 ...` : trace un polygone fermé.
- `curve x1 y1 x2 y2 x3 y3 x4 y4` : trace une courbe de Bézier.
- `list`, `select`, `delete`, `new` : gestion des calques, arias et formes.
- `set char {border, background} ascii_code` : personnalise les caractères de la grille.
- `set layer {visible, unvisible} {id}` : affiche ou masque un calque.

> Exemple de session :
>
> `~> circle 10 10 5`
>
> `~> help`

---

# Partie Java

La version Java propose également une interface interactive pour créer et dessiner des formes sur une grille ASCII.

## Ce que fait le code Java

Le projet `pixel_tracer_java` est une petite application en ligne de commande qui permet de dessiner des formes géométriques sous forme de pixels dans une grille texte.

Les composants principaux sont :

- `Main.java` : le point d'entrée de l'application.
- `pixel.PixelTracerApp` : stocke l'état global de l'application :
  - `areas` : liste des zones de dessin,
  - `currentArea` : la zone active,
  - `currentLayer` : la couche active,
  - `currentShape` : forme active (pas beaucoup utilisée dans `Main`).
- `area.Area` : représente une grille 2D de caractères.
- `layer.Layer` : contient des `Shape` et gère la visibilité d'une couche.
- `shape.*` : différentes formes possibles :
  - `Point`, `Line`, `Circle`, `Rectangle`, `Polygone`, `Curve`.
- `pixel.PixelConverter` : transforme chaque forme en une liste de `Pixel`.
- `render.Render` : dessine les pixels sur la grille et affiche la grille à l’écran.

### Ce qui est lancé dans `main`

Dans `Main.main(...)`, voici les étapes :

1. Création de l'application :

   - `PixelTracerApp app = new PixelTracerApp();`
   - Cela initialise une zone de dessin par défaut de `80 x 24`.

2. Création d'une couche par défaut :

   - `Layer defaultLayer = new Layer(0, "Formes");`
   - `app.currentArea.addLayer(defaultLayer);`
   - `app.currentLayer = defaultLayer;`

3. Initialisation du mode interactif :

   - `Scanner scanner = new Scanner(System.in);`
   - `Render.clearScreen();`
   - affichage de l'aide avec `displayHelp();`
   - affichage initial de la grille vide avec `Render.renderArea(app.currentArea);`

4. Boucle principale infinie :

   - lecture des commandes saisies par l’utilisateur.
   - exécution de la commande selon le mot clé.

### Commandes gérées dans `main`

Le `switch` du main gère :

- `quit` / `exit`
  - quitte l’application.
- `help`
  - affiche l’aide.
- `point <x> <y> <color_hex>`
  - crée un point et l’ajoute à la couche.
  - relance le rendu.
- `line <x1> <y1> <x2> <y2> <color_hex>`
  - crée une ligne entre deux points.
- `circle <x> <y> <radius> <color_hex>`
  - crée un cercle.
- `rectangle <x> <y> <width> <height> <color_hex>`
  - crée un rectangle.
- `polygone ... <color_hex>`
  - crée un polygone fermé à partir d’une liste de sommets.
- `curve <x1> <y1> <x2> <y2> <x3> <y3> <x4> <y4> <color_hex>`
  - crée une courbe de Bézier cubique approximée par des segments.
- `clear`
  - efface toute la zone et la grille.
- `render`
  - redessine la zone actuelle.

Pour chaque forme ajoutée, `Main` appelle :

- `app.currentLayer.addShape(...)`
- `Render.drawAllLayers(app.currentArea)`
- `Render.renderArea(app.currentArea)`

### Comment le rendu fonctionne

Dans `render.Render` :

- `drawAllLayers(area)` :
  - vide la grille `area.clear()`,
  - parcourt toutes les couches visibles,
  - convertit chaque forme en pixels via `PixelConverter.shapeToPixels(shape)`,
  - place ces pixels dans la grille.
- `renderArea(area)` :
  - affiche la matrice de caractères sur la console.
  - les pixels sont dessinés comme `#`,
  - le reste de la grille est affiché tel quel.
- `clearScreen()` :
  - utilise des codes ANSI pour effacer le terminal.

### À noter

- Le code gère bien la saisie interactive et les erreurs de paramètres.
- La couleur est parsée en hexadécimal, mais le rendu console utilise un caractère `#` fixe.
- La structure est simple : un canevas, des couches, des formes, un convertisseur en pixels et un rendu texte.

## Installation

Assurez-vous d’avoir Java et Maven installés :

```bash
sudo apt install default-jdk maven
```

## Compilation et exécution

```bash
cd /home/etudiant/Documents/pixel_tracer-main_1/maintenance_applicative/pixel_tracer_java
mvn compile
mvn exec:java
```

## Commandes Java disponibles

- `point <x> <y> <color_hex>` : crée un point.
- `line <x1> <y1> <x2> <y2> <color_hex>` : crée une ligne.
- `circle <x> <y> <radius> <color_hex>` : crée un cercle.
- `rectangle <x> <y> <width> <height> <color_hex>` : crée un rectangle.
- `polygone <x1> <y1> <x2> <y2> <x3> <y3> [<xn> <yn>...] <color_hex>` : crée un polygone.
- `curve <x1> <y1> <x2> <y2> <x3> <y3> <x4> <y4> <color_hex>` : crée une courbe de Bézier.
- `clear` : efface la grille.
- `render` : redessine toutes les formes.
- `help` : affiche l’aide.
- `quit` / `exit` : quitte l’application.

## Exemples de commandes Java

- `point 10 5 FF0000`
- `line 2 2 15 10 00FF00`
- `circle 5 5 16 FF0000`
- `rectangle 2 2 8 4 0000FF`
- `polygone 2 2 8 2 8 6 2 6 FF00FF`
- `curve 2 2 4 10 8 10 10 2 00FFFF`

## Structure du projet

- `pixel_tracer_c/` : implémentation C du tracer de formes.
- `pixel_tracer_java/` : implémentation Java orientée objet.

> Le code C est la version historique du projet, la version Java permet d’explorer une architecture objet et un rendu pixelisé basé sur des formes.
