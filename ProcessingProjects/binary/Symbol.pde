class Symbol
{
  float x;
  float y;
  float value;
  float speed;
  float interval;
  boolean first;
  float opacity;

  Symbol(float X, float Y, float S, boolean f, float o) {
    this.x = X;
    this.y = Y;
    this.speed = S;
    this.first = f;
    this.opacity = o;
    this.interval = round(random(2, 25));
    this.value = 0;
  }
  Symbol(){
  }
  void setToRandomSymbol()
  {
    //int charType = round(random(0, 5)); 
    if (frameCount % this.interval == 0) {
      if (round(random(0, 1)) > 0.5) {
        this.value = 0;
      } else {
        this.value = 1;
      }
    }
  }
  void rain() {
    if (this.y >= height) {
      this.y = 0;
    } else {
      this.y += this.speed;
    }
  }
};