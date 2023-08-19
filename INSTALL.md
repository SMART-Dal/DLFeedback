# Experiment Installation Procedure

This document outlines the installation procedure for the experiment, presenting two distinct installation approaches, both detailed below.

## Experiment Setup using Existing Deep-Learning Models

This setup entails utilizing pre-existing pre-trained deep learning models to recreate the experiment components. To replicate the process, follow these steps:

- Clone the repository using the command `gh repo clone SMART-Dal/DLFeedback`.
- Navigate to the "DeployableServer/django_server/" folder.
- Build the image by executing `docker-compose build`.
- Launch the container with the command `docker-compose up`.
- Open the IntelliJ IDE and access the "IntelliJPlugin" folder.
- Open the settings dialog.
- Click on the plugin tab.
- Select the settings menu and click 'Install from disk.'
- Import the plugin file `IntelliJPlugin/TagmanPlugin-1.0-SNAPSHOT.zip`.  
- Load the repository located at https://github.com/himesh13/Tagman_Phase2 in the IDE.

## Experiment Setup after Building the Deep-Learning Models

Deep learning models are constructed in this setup to recreate the experiment components. To follow this approach, adhere to these steps:

- Clone the repository using the command `gh repo clone SMART-Dal/DLFeedback`.
- Navigate to the "DL-Models\smell-detection-dl-win\" folder.
- Execute the Jupyter notebook corresponding to the intended model. This will run the model and generate results for the state-of-the-art reference models.
- Navigate to the  `DL-Models\smell-detection-dl-win\Py-Scripts\program\dl_models\` folder.
- Run the VAE_xx.py file, where "xx" represents the specific smell.
- Navigate to the "DeployableServer/django_server/" folder.
- Build the image with the command `docker-compose build`.
- Run the container by executing `docker-compose up`.
- Open the settings dialog.
- Click on the plugin tab.
- Select the settings menu and click 'Install from disk.'
- Import the plugin file `IntelliJPlugin/TagmanPlugin-1.0-SNAPSHOT.zip`.  
- Load the repository located at https://github.com/himesh13/Tagman_Phase2 in the IDE.

