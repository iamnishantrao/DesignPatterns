
import java.util.HashMap;
import java.util.Map;

// Client class
public class Solution {
    public static void main(String[] args) {

        MapCell[][] map = new MapCell[5][5];

        // Initialize map
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String terrainType;
                if (i == j) {
                    terrainType = "mountain";
                } else if (i > j) {
                    terrainType = "water";
                } else {
                    terrainType = "grass";
                }
                map[i][j] = new MapCell(i, j, terrainType);
            }
        }

        // Render map
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j].render();
            }
        }

        System.out.println("Total unique terrain tiles: " + TerrainFactory.getTileCount());
    }
}

// Flyweight interface
interface MapTile {

    void render(int x, int y);
}

// Concrete Flyweight
class TerrainTile implements MapTile {

    private final String terrain;
    private final int[] color;

    public TerrainTile(String terrain, int[] color) {

        this.terrain = terrain;
        this.color = color;
    }

    public void render(int x, int y) {

        System.out.printf("Rendering %s tile at (%d, %d) with color RGB(%d, %d, %d)%n", terrain, x, y, color[0], color[1], color[2]);
    }
}

// Flyweight Factory
class TerrainFactory {

    private static final Map<String, MapTile> terrainTiles = new HashMap<>();

    public static MapTile getTerrain(String terrain) {

        MapTile tile = terrainTiles.get(terrain);

        if (tile == null) {

            switch (terrain) {

                case "grass":
                    tile = new TerrainTile("grass", new int[]{0, 255, 0});
                    break;

                case "water":
                    tile = new TerrainTile("water", new int[]{0, 0, 255});
                    break;
                    
                case "mountain":
                    tile = new TerrainTile("mountain", new int[]{139, 69, 19});
                    break;

                default:
                    tile = new TerrainTile("unknown", new int[]{128, 128, 128});
            }

            terrainTiles.put(terrain, tile);
        }

        return tile;
    }

    public static int getTileCount() {

        return terrainTiles.size();
    }
}

// Context class that uses the flyweight
class MapCell {

    private final int x;
    private final int y;
    private final MapTile terrain;

    public MapCell(int x, int y, String terrainType) {

        this.x = x;
        this.y = y;
        this.terrain = TerrainFactory.getTerrain(terrainType);
    }

    public void render() {
        
        terrain.render(x, y);
    }
}
