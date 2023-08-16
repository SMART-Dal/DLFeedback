# Code Smell Detection Repository

This repository contains multiple projects related to code smell detection. Each project focuses on a different aspect of code smell detection.

## Projects

1. **Deployable Server**: The server utilizes machine learning techniques to automate code smell detection, making the process faster and more efficient.
2. **Experiment Data**: This project contains all the raw data collected from the experiment.
3. **Research Scripts**: This project houses all the research scripts we used to generate the results for each research question.
4. **Deep Learning Models**: This project implements and compares four deep learning approaches for code smell detection. The models include CodeBERT, CodeT5, Autoencoder with Logistic Regression (AutoLR), Autoencoder with LSTM (AutoLSTM), and Variational Autoencoder (VAE). Each model has its own Jupyter notebook with detailed instructions for running the model.
5. **User Feedback Integration**: This project explores user-specific subjective analysis and aims to customize smell detection based on the user's perspective or context. It incorporates user feedback into the deep learning models, fine-tunes the models based on the feedback, and compares the performance of the fine-tuned models with the original models.

## Prerequisites

- Dataset (Follow the instructions at [![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.7570428.svg)](https://doi.org/10.5281/zenodo.7570428) to download the dataset). 
- Python 3.x
- Jupyter Notebook
- PyTorch
- Transformers library (for CodeBERT and CodeT5)
- Tensorflow (for VAE)
- Other dependencies as mentioned in the individual project README files

## Usage

1. Clone or download this repository to your local machine.
2. Navigate to the specific project directory you are interested in.
3. Follow the instructions provided in the README file of that project to set up and run the code.

## Notes
1. For added convenience, all the necessary python libraries for all the subprojects can be installed using the `requirements.txt` file. 
Use the command below to install all the dependencies using pip:
`pip install -r requirements.txt` 