Matrix m[];
int count = 200;
void setup()
{
  m = new Matrix[count];
  for (int i=0; i<count; i++)
    m[i] = new Matrix();
  size(1000, 1000);
}
void draw()
{
  background(0);
  for (int i=0; i<count; i++) {
    m[i].show();
    m[i].speed();
  }
}

class Matrix
{  
  float x1, y1;
  float dis;
  float z;
  float yspeed;

  Matrix()
  {
    x1 = random(width);
    y1 = random(-500, -50);
    dis = map(z, 0, 20, 20, 30); 
    yspeed = map(z, 0, 20, 1, 20);
    z = random(0, 20);
  }
  void show()
  {
    float thick = map(z, 0, 20, 0.5, 1);
    strokeWeight(thick);
    stroke(#03FF15);
    line(x1, y1, x1, y1+dis);
  }
  void speed()
  {
    y1 += yspeed;
    float gravity = map(z, 0, 20, 0, 0.2);
    yspeed += gravity;

    if (y1 > height) {
      y1 = random(-00, -100);
      yspeed = map(z, 0, 20, 4, 10);
    }
  }
};