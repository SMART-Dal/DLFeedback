# Code Smell Detection Django Server

This Django server serves as the central processing unit for code smell detection in software projects. 
It provides an API endpoint to accept classes or methods as input and determines if they exhibit code smells. 
The server utilizes machine learning techniques to automate code smell detection, making the process faster and more efficient.

## Features

- Code smell detection: The server uses a trained deep learning model to predict code smells in classes or methods provided as input.
- Customization: The model can be fine-tuned based on user feedback to make it specific to the user's preferences and context, allowing for personalized code smell detection.
- Docker containerization: The server is containerized using Docker, ensuring easy deployment and scalability. This simplifies the setup and integration of the code smell detection system into existing software development workflows.

## Prerequisites

- Python 3.7 or higher
- Django 3.2 or higher
- Docker-Compose

## Installation

1. Clone the repository. 

## Usage
1. Change the directory to DeployableServer
`cd DeployableServer\ `
2. Build the docker container: docker-compose build
3. Run the docker container: docker-compose up

## Notes

1. The weights are located at the location: 
`DeployableServer\`
These can be changed and updated as needed. 
2. The code is currently setup to work with the experiment group. To change it to work with the control group, change the variable `experiment` to False within the class DeployableServer\django_server\server\api\EncoderModel.py
