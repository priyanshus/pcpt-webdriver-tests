package org.pcpt.test.mudule.login;

public class Test {
	public String name;
	public String age;
	public Image image;
	
	
	public class Image {
		public String url;
		public int width;
		public int height;
		
		public Image() {
			
		}
		
		public Image(String url, int width, int height) {
			this.url = url;
			this.width = width;
			this.height = height;
		}
	}

}
