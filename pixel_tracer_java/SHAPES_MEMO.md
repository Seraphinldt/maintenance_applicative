# Mémo des formes et commandes disponibles

## Aide actuelle affichée par le programme

=== PIXEL TRACER - Aide ===
Commandes disponibles:
  point <x> <y> <color_hex>       - Créer un point
  line <x1> <y1> <x2> <y2> <color_hex> - Créer une ligne
  circle <x> <y> <radius> <color_hex> - Créer un cercle
  clear                            - Effacer la grille
  render                           - Afficher la grille
  help                             - Afficher cette aide
  quit / exit                      - Quitter
Exemple: point 10 5 FF0000

## Explication des commandes

- `point <x> <y> <color_hex>`
  - Ajoute un point à la position `(x, y)`.
  - Exemple : `point 10 5 FF0000`

- `line <x1> <y1> <x2> <y2> <color_hex>`
  - Trace une ligne entre les points `(x1, y1)` et `(x2, y2)`.
  - Exemple : `line 2 2 15 10 00FF00`

- `circle <x> <y> <radius> <color_hex>`
  - Crée un cercle centré en `(x, y)` avec le rayon indiqué.
  - Exemple : `circle 5 5 16 FF0000`

- `clear`
  - Réinitialise la grille et efface toutes les formes.

- `render`
  - Redessine toutes les formes actuellement présentes.

- `help`
  - Affiche de nouveau cette aide.

- `quit` / `exit`
  - Quitte le programme.

## Remarques sur les formes supportées

Le programme accepte actuellement les formes suivantes :
- `Point`
- `Line`
- `Circle`

D'autres classes existent dans le code (`Rectangle`, `Polygone`, `Curve`) mais elles ne sont pas exposées par une commande interactive dans l'état actuel.

## Exemple de commande utile

- `circle 5 5 16 FF0000` : tracer un cercle rouge de rayon 16 centré en `(5, 5)`.
- `line 1 1 10 10 0000FF` : tracer une ligne bleue.
- `point 7 3 00FF00` : placer un point vert.
