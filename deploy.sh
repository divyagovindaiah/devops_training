#!/bin/sh  
#!/bin/bash
########################################################## Shell Script to Build Docker Image by FOSSTechNix.com &nbsp; ########################################################DATE=`date +%Y.%m.%d.%H.%M'
echo "build the docker image"
sudo docker build  -t deployimage:1.0.1 .
echo "built docekr images and list the images"
sudo docker images
echo "run the image"
sudo docker run deployimage:1.0.1
echo "push the image into dockerhub"
sudo docker tag  deployimage:1.0.1  divyagovindaiah123/deployimage:1.0.1
echo "push the iamge"
sudo docker push divyagovindaiah123/deployimage:1.0.1

