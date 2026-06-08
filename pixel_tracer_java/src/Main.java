import shape.*;
import layer.Layer;
import render.Render;
import pixel.PixelTracerApp;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PixelTracerApp app = new PixelTracerApp();
        
        // Ajouter une couche par défaut
        Layer defaultLayer = new Layer(0, "Formes");
        app.currentArea.layers.add(defaultLayer);
        app.currentLayer = defaultLayer;
        
        Scanner scanner = new Scanner(System.in);

        // Afficher la grille initiale
        Render.clearScreen();
        displayHelp();
        Render.renderArea(app.currentArea);

        // Boucle interactive
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) continue;

            String[] parts = input.split("\\s+");
            String command = parts[0].toLowerCase();

            try {
                switch (command) {
                    case "quit":
                    case "exit":
                        System.out.println("Au revoir!");
                        scanner.close();
                        return;

                    case "help":
                        displayHelp();
                        break;

                    case "point":
                        // point x y color
                        if (parts.length >= 4) {
                            int x = Integer.parseInt(parts[1]);
                            int y = Integer.parseInt(parts[2]);
                            int color = Integer.parseInt(parts[3], 16);
                            Point p = new Point();
                            p.setPos_x(x);
                            p.setPos_y(y);
                            p.setColor(color);
                            app.currentLayer.addShape(p);
                            System.out.println("Point ajouté: (" + x + ", " + y + ")");
                            Render.drawAllLayers(app.currentArea);
                            Render.renderArea(app.currentArea);
                        } else {
                            System.out.println("Usage: point <x> <y> <color_hex>");
                        }
                        break;

                    case "line":
                        // line x1 y1 x2 y2 color
                        if (parts.length >= 6) {
                            Point p1 = new Point();
                            p1.setPos_x(Integer.parseInt(parts[1]));
                            p1.setPos_y(Integer.parseInt(parts[2]));
                            
                            Point p2 = new Point();
                            p2.setPos_x(Integer.parseInt(parts[3]));
                            p2.setPos_y(Integer.parseInt(parts[4]));
                            
                            Line line = new Line();
                            line.setP1(p1);
                            line.setP2(p2);
                            line.setColor(Integer.parseInt(parts[5], 16));
                            app.currentLayer.addShape(line);
                            System.out.println("Ligne ajoutée");
                            Render.drawAllLayers(app.currentArea);
                            Render.renderArea(app.currentArea);
                        } else {
                            System.out.println("Usage: line <x1> <y1> <x2> <y2> <color_hex>");
                        }
                        break;

                    case "circle":
                        // circle x y radius color
                        if (parts.length >= 5) {
                            Point center = new Point();
                            center.setPos_x(Integer.parseInt(parts[1]));
                            center.setPos_y(Integer.parseInt(parts[2]));
                            
                            Circle circle = new Circle();
                            circle.setCenter(center);
                            circle.setColor(Integer.parseInt(parts[4], 16));
                            app.currentLayer.addShape(circle);
                            System.out.println("Cercle ajouté");
                            Render.drawAllLayers(app.currentArea);
                            Render.renderArea(app.currentArea);
                        } else {
                            System.out.println("Usage: circle <x> <y> <radius> <color_hex>");
                        }
                        break;

                    case "clear":
                        app.currentArea.clear();
                        app.currentLayer.shapes.clear();
                        System.out.println("Grille effacée");
                        Render.renderArea(app.currentArea);
                        break;

                    case "render":
                        Render.drawAllLayers(app.currentArea);
                        Render.renderArea(app.currentArea);
                        System.out.println();
                        break;

                    default:
                        System.out.println("Commande inconnue. Tapez 'help' pour l'aide.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur: paramètres invalides");
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        }
    }

    static void displayHelp() {
        System.out.println("\n=== PIXEL TRACER - Aide ===");
        System.out.println("Commandes disponibles:");
        System.out.println("  point <x> <y> <color_hex>       - Créer un point");
        System.out.println("  line <x1> <y1> <x2> <y2> <color_hex> - Créer une ligne");
        System.out.println("  circle <x> <y> <radius> <color_hex> - Créer un cercle");
        System.out.println("  clear                            - Effacer la grille");
        System.out.println("  render                           - Afficher la grille");
        System.out.println("  help                             - Afficher cette aide");
        System.out.println("  quit / exit                      - Quitter");
        System.out.println("Exemple: point 10 5 FF0000\n");
    }
}
