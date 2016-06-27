package java.company;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class InputParser {
    private File file;
    private File indexFile;
    private File itemsFile;
    private final ObjectMapper objectMapper;

    public InputParser(File file) {
        this.file = file;
    public InputParser(File indexFile, File itemsFile) {
        this.indexFile = indexFile;
        this.itemsFile = itemsFile;
        objectMapper = new ObjectMapper(new JsonFactory());
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    public ShoppingChart parser() throws IOException {
        String textInput = FileUtils.readFileToString(file);
        Item[] items = objectMapper.readValue(textInput, Item[].class);
        return BuildShoppingChart(items);
        return BuildShoppingChart(getBoughtItemBarCodes(), getItemIndexes());
    }

    private ShoppingChart BuildShoppingChart(Item[] items) {
    private ShoppingChart BuildShoppingChart(String[] barCodes, HashMap<String, Item> itemIndexes) {
        ShoppingChart shoppingChart = new ShoppingChart();
        for (Item item : items){
        for (String barcode : barCodes) {
            Item mappedItem = itemIndexes.get(barcode);
            Item item = new Item(barcode, mappedItem.getName(), mappedItem.getUnit(), mappedItem.getPrice(), mappedItem.getDiscount());
            shoppingChart.add(item);
        }
        return shoppingChart;
    }

    private String[] getBoughtItemBarCodes() throws IOException {
        String itemsStr = FileUtils.readFileToString(itemsFile);
        return objectMapper.readValue(itemsStr, String[].class);
    }

    private HashMap<String, Item> getItemIndexes() throws IOException {
        String itemsIndexStr = FileUtils.readFileToString(indexFile);
        TypeReference<HashMap<String,Item>> typeRef = new TypeReference<HashMap<String,Item>>() {};
        return objectMapper.readValue(itemsIndexStr, typeRef);
    }

}
