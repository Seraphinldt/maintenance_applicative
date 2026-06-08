import shape.*;
import layer.Layer;
import render.Render;
import pixel.PixelTracerApp;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PixelTracerApp app = new PixelTracerApp();
        
        // Ajouter une couche par défaut
        Layer defaultLayer = new Layer(0, "Formes");
        app.currentArea.addLayer(defaultLayer);
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
                            int radius = Integer.parseInt(parts[3]);
                            
                            Circle circle = new Circle();
                            circle.setCenter(center);
                            circle.setRadius(radius);
                            circle.setColor(Integer.parseInt(parts[4], 16));
                            app.currentLayer.addShape(circle);
                            System.out.println("Cercle ajouté");
                            Render.drawAllLayers(app.currentArea);
                            Render.renderArea(app.currentArea);
                        } else {
                            System.out.println("Usage: circle <x> <y> <radius> <color_hex>");
                        }
                        break;

                    case "rectangle":
                        // rectangle x y width height color
                        if (parts.length >= 6) {
                            Point origin = new Point();
                            origin.setPos_x(Integer.parseInt(parts[1]));
                            origin.setPos_y(Integer.parseInt(parts[2]));
                            int width = Integer.parseInt(parts[3]);
                            int height = Integer.parseInt(parts[4]);
                            Rectangle rectangle = new Rectangle();
                            rectangle.setP1(origin);
                            rectangle.setWidth(width);
                            rectangle.setHeight(height);
                            rectangle.setColor(Integer.parseInt(parts[5], 16));
                            app.currentLayer.addShape(rectangle);
                            System.out.println("Rectangle ajouté");
                            Render.drawAllLayers(app.currentArea);
                            Render.renderArea(app.currentArea);
                        } else {
                            System.out.println("Usage: rectangle <x> <y> <width> <height> <color_hex>");
                        }
                        break;

                    case "polygone":
                    case "polygon":
                        // polygone x1 y1 x2 y2 x3 y3 [x4 y4 ...] color
                        if (parts.length >= 8 && ((parts.length - 2) % 2 == 0)) {
                            int color = Integer.parseInt(parts[parts.length - 1], 16);
                            ArrayList<Point> points = new ArrayList<>();
                            for (int i = 1; i < parts.length - 1; i += 2) {
                                Point vertex = new Point();
                                vertex.setPos_x(Integer.parseInt(parts[i]));
                                vertex.setPos_y(Integer.parseInt(parts[i + 1]));
                                points.add(vertex);
                            }
                            if (points.size() >= 3) {
                                Polygone polygone = new Polygone();
                                polygone.setPoints(points);
                                polygone.setColor(color);
                                app.currentLayer.addShape(polygone);
                                System.out.println("Polygone ajouté");
                                Render.drawAllLayers(app.currentArea);
                                Render.renderArea(app.currentArea);
                            } else {
                                System.out.println("Usage: polygone <x1> <y1> <x2> <y2> <x3> <y3> [<xn> <yn>...] <color_hex>");
                            }
                        } else {
                            System.out.println("Usage: polygone <x1> <y1> <x2> <y2> <x3> <y3> [<xn> <yn>...] <color_hex>");
                        }
                        break;

                    case "curve":
                        // curve x1 y1 x2 y2 x3 y3 x4 y4 color
                        if (parts.length >= 10) {
                            Point p1 = new Point();
                            p1.setPos_x(Integer.parseInt(parts[1]));
                            p1.setPos_y(Integer.parseInt(parts[2]));
                            Point p2 = new Point();
                            p2.setPos_x(Integer.parseInt(parts[3]));
                            p2.setPos_y(Integer.parseInt(parts[4]));
                            Point p3 = new Point();
                            p3.setPos_x(Integer.parseInt(parts[5]));
                            p3.setPos_y(Integer.parseInt(parts[6]));
                            Point p4 = new Point();
                            p4.setPos_x(Integer.parseInt(parts[7]));
                            p4.setPos_y(Integer.parseInt(parts[8]));
                            Curve curve = new Curve();
                            curve.setP1(p1);
                            curve.setP2(p2);
                            curve.setP3(p3);
                            curve.setP4(p4);
                            curve.setColor(Integer.parseInt(parts[9], 16));
                            app.currentLayer.addShape(curve);
                            System.out.println("Courbe ajoutée");
                            Render.drawAllLayers(app.currentArea);
                            Render.renderArea(app.currentArea);
                        } else {
                            System.out.println("Usage: curve <x1> <y1> <x2> <y2> <x3> <y3> <x4> <y4> <color_hex>");
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
        System.out.println("  rectangle <x> <y> <width> <height> <color_hex> - Créer un rectangle");
        System.out.println("  polygone <x1> <y1> <x2> <y2> <x3> <y3> [<xn> <yn>...] <color_hex> - Créer un polygone");
        System.out.println("  curve <x1> <y1> <x2> <y2> <x3> <y3> <x4> <y4> <color_hex> - Créer une courbe de Bézier");
        System.out.println("  clear                            - Effacer la grille");
        System.out.println("  render                           - Afficher la grille");
        System.out.println("  help                             - Afficher cette aide");
        System.out.println("  quit / exit                      - Quitter");
        System.out.println("Exemple: point 10 5 FF0000\n");
    }
}
