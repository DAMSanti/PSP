package org.example;

import org.example.utils.ImageProcessor;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java -jar Proyecto.jar <image-path>");
            return;
        }

        String imagePath = args[0];
        Mat image = ImageProcessor.loadImage(imagePath);
        ImageProcessor.detectAndMeasureObjects(image);
    }
}