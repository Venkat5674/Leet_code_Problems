class Robot {

    // Instance variables
    private int x, y;
    private int width, height;
    private String dir;

    // Constructor
    public Robot(int width, int height) {
        this.x = 0;
        this.y = 0;
        this.dir = "East";
        this.width = width;
        this.height = height;
    }

    // Move robot
    public void step(int num) {
        int perimeter = 2 * (width - 1) + 2 * (height - 1);

        num %= perimeter;
        if (num == 0) num = perimeter;

        while (num > 0) {

            if (dir.equals("East")) {
                int move = Math.min(num, (width - 1) - x);
                x += move;
                num -= move;

                if (num > 0) dir = "North";
            }

            else if (dir.equals("North")) {
                int move = Math.min(num, (height - 1) - y);
                y += move;
                num -= move;

                if (num > 0) dir = "West";
            }

            else if (dir.equals("West")) {
                int move = Math.min(num, x);
                x -= move;
                num -= move;

                if (num > 0) dir = "South";
            }

            else if (dir.equals("South")) {
                int move = Math.min(num, y);
                y -= move;
                num -= move;

                if (num > 0) dir = "East";
            }
        }
    }

    // Get current position
    public int[] getPos() {
        return new int[]{x, y};
    }

    // Get current direction
    public String getDir() {
        return dir;
    }
}
