public record Moeda(String base_code, String target_code, double conversion_rate) {
    @Override
    public final String toString() {
        return "Moeda escolhida para converter: " + base_code + "\n Moeda para ser convertida: " + target_code + "\n" +
                "1 " + base_code + " equivale a " + conversion_rate + " " + target_code;
    }
}
