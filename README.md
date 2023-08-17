# Code Smell Detection Repository

This repository contains multiple projects related to code smell detection. Each project focuses on a different aspect of code smell detection.

## Calibrating Deep Learning-based Code Smell Detection using Human Feedback

## Abstract 
Code smells are inherently subjective in nature. Software developers may have different opinions and perspectives on smelly code. While many attempts have been made to use deep learning-based models for code smell detection, they fail to consider each developer's subjective perspective while detecting smells. Ignoring this aspect defies the purpose of using deep learning-based smell detection methods because the models are not customized to the developer's context. This paper proposes a method that considers human feedback to account for such subjectivity. Towards this, we created a plugin for IntelliJ IDEA and developed a container-based web-server to offer services of our baseline deep learning model. The setup allowed developers to see code smells within the IDE and provide feedback. 
Using this setup, we conducted a controlled experiment with 14 participants divided into experimental and control groups. In the first round of our experiment, we show code smells predicted using the baseline deep learning model and collect feedback from the participants.
In the second round, we fine-tune the model based on the experimental group's feedback and reevaluate its performance before and after adjustment. Our results show that using such calibration improves the performance of the smell detection model by 15.49\% in F1 score on average across the participants of the experimental group. Our work carries implications for both researchers and practitioners. Practitioners can apply our approach to enhance the quality of their code in day-to-day development activities, aligning it with their own code smell definitions. Furthermore, software engineering researchers can leverage this study to adopt analogous approaches for addressing similar issues, including code review. 

## Projects

1. **Deployable Server**: The server utilizes machine learning techniques to automate code smell detection, making the process faster and more efficient.
2. **Experiment Data**: This project contains all the raw data collected from the experiment.
3. **Research Scripts**: This project houses all the research scripts we used to generate the results for each research question.
4. **Deep Learning Models**: This project implements and compares four deep learning approaches for code smell detection. The models include CodeBERT, CodeT5, Autoencoder with Logistic Regression (AutoLR), Autoencoder with LSTM (AutoLSTM), and Variational Autoencoder (VAE). Each model has its own Jupyter notebook with detailed instructions for running the model.
5. **User Feedback Integration**: This project explores user-specific subjective analysis and aims to customize smell detection based on the user's perspective or context. It incorporates user feedback into the deep learning models, fine-tunes the models based on the feedback, and compares the performance of the fine-tuned models with the original models.

## Prerequisites

- Dataset (Follow the instructions at [![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.7570428.svg)](https://doi.org/10.5281/zenodo.7570428) to download the dataset).
- Github CLI
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
