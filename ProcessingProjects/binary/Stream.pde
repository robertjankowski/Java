class Stream
{
  // tu cos nie tak z array
  ArrayList<Symbol> symbols = new ArrayList<Symbol>();
  int totalSymbols = round(random(5, 35));
  float speed = random(5, 22);

  void generateSymbols(float x, float y) {
    float opacity = 255;
    boolean first = round(random(0, 4)) == 1;
    for (int i=0; i<=this.totalSymbols; i++) {
      Symbol s = new Symbol(x, y, this.speed, first, opacity);
      s.setToRandomSymbol();
      this.symbols.add(s); // poprawka
      opacity -= (255/this.totalSymbols)/fadeInterval;
      y -= symbolSize;
      first = false;
    }
  }
  void render()
  {
    for (int i=0; i<symbols.size(); i++) {
      Symbol symbol = new Symbol();
      if (symbol.first) {
        fill(140, 255, 170, symbol.opacity);
      } else {
        fill(0, 255, 70, symbol.opacity);
      }
      symbol.rain();
      symbol.setToRandomSymbol();
    }
  }
};