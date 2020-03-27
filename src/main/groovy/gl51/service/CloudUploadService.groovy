package gl51.service

import gl51.data.Image

interface CloudUploadService {
/*
   Ceci permet le stockage des images générées dans le Cloud
*/
    public  uploadToCloud(Image imageaimporter)
}