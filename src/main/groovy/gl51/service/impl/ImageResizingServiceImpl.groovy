package gl51.service.impl

import gl51.data.Image
import gl51.service.CloudUploadService
import gl51.service.ImageFiligraneService
import gl51.service.ImageResizingService
import gl51.service.ImageService

import gl51.service.UptdateDataBaseService

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageResizingServiceImpl implements ImageResizingService {
    @Inject
    ImageService imageService

    @Inject
    CloudUploadService cloudUploadService

    @Inject
    UptdateDataBaseService updateDataBaseService

    @Inject
    ImageFiligraneService imageFiligraneService

    @Override
    Image resize(Image imageSource, int newDimensionX, int newDimensionY) {
    }

    @Override
    Image getAndResizeImage() {
        //Récupération de l'image
        Image imageSource=imageService.fetchImage()

        //Redimensionnement de l'image au format 1024*1024
        Image newImage=resize(imageSource,1024,1024)

        //Création du thumbail
        Image thumbnail=resize(imageSource,50,50)

        //Ajout du filigrane
        Image logo=imageFiligraneService.add_filigrane(thumbnail)

        //Stockage dans le cloud
        cloudUploadService.uploadToCloud(newImage)
        cloudUploadService.uploadToCloud(logo)

        //Mise à jour de la base de données
        updateDataBaseService.updateDatabase(newImage.getDimensionX(),newImage.getDimensionY(),newImage.getNom())

    }
}
