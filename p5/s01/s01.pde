int sizeSq = 1200;
int margin = sizeSq/200;
int delta =5; 
int backColor = 0x000000;
int resolution = 30;
void settings(){
	size(sizeSq, sizeSq);
}
void setup(){
	background(backColor);
	circleDraw(sizeSq/3, sizeSq/2);
	circleDraw(sizeSq*2/3, sizeSq/2);
	blendMode(BLEND);
	noStroke();
	fill(#000000);
	circle(sizeSq/3, sizeSq/2, sizeSq/2-resolution);
	circle(sizeSq*2/3, sizeSq/2, sizeSq/2-resolution);
}
void draw(){
}
void circleDraw(int x, int y){
	int sum = resolution*(resolution-1)/2;
	blendMode(SCREEN);
	noFill();
	for(int i=1; i<resolution; i++){
		strokeWeight(5*(resolution-i));
		stroke(map(map(i,0,resolution,0,sum),0,sum,0,255),8,8,50);
		circle(x, y, sizeSq/2-resolution);
	}
}
