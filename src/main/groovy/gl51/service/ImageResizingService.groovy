package gl51.service

import gl51.data.Image

interface ImageResizingService {
/*
   Ceci convertit une image à la taille 1024*1024
*/
                Image resize(Image imageSource, int newDimensionX, int newDimensionY)
        Image getAndResizeImage()
}