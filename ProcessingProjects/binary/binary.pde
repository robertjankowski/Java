

ArrayList<Stream> streams = new ArrayList<Stream>();
float fadeInterval = 1.6;
int symbolSize = 14;

void setup() {
  size(600, 400);
  background(0);
  int x=0;
  for (int i=0; i<=width/symbolSize; i++) {
    Stream stream = new Stream();
    stream.generateSymbols(x, random(-2000, 1));
    streams.add(stream);
    x+= symbolSize;
  }
  textSize(symbolSize);
}

void draw() {
  background(0, 155);
  // streams.redner();
}