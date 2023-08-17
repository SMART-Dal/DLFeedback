This file describes the installation procedure for the experiment. There are two ways of installing the experiment. They are both detailed below. 

## Experiment Setup using existing Deep-Learning models

This setup involves using existing pre-trained deep learning models to replicate the experiment instruments. To replicate the process, follow the following steps: 

- Clone the repository using
  `gh repo clone SMART-Dal/DLFeedback`
- Navigate to the "DeployableServer/django_server/" folder
- To build the image, run `docker-compose build`
- To run the container, run `docker-compose up`
- Open the IntelliJ IDE and open the "IntelliJPlugin" folder
- Run the "runIde" goal in the IntelliJ IDE. This should automatically open a new instance of IDE with the plugin loaded.
- Load the repository at  https://github.com/himesh13/Tagman_Phase2 in the IDE.

## Experiment Setup after building the Deep-Learning models 

This setup involves building deep learning models to replicate the experiment instruments. To replicate the process, follow the following steps: 

- Clone the repository using
`gh repo clone SMART-Dal/DLFeedback`
- Navigate to "DL-Models\smell-detection-dl-win\" folder
- Run the jupyter notebook  for the corresponding model. That will run the model and generate the results for the SOA reference models. 
- Navigate to the "DL-Models\smell-detection-dl-win\Py-Scripts\program\dl_models\" folder
- Run the VAE_xx.py file where xx denotes the smell.
- Navigate to the "DeployableServer/django_server/" folder
- To build the image, run `docker-compose build`
- To run the container, run `docker-compose up`
- Open the IntelliJ IDE and open the "IntelliJPlugin" folder
- Run the "runIde" goal in the IntelliJ IDE. This should automatically open a new instance of IDE with the plugin loaded.
- Load the repository at  https://github.com/himesh13/Tagman_Phase2 in the IDE.

   
