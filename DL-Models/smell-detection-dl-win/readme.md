# Deep Learning Models for Code Smell Detection

This repository contains implementations for three deep learning models for code smell detection. 
The AE-LR model and AE-LSTM models are implemented as Jupyter notebooks. Each notebook focuses on a specific deep learning approach and provides step-by-step instructions for running the model.

## Models

1. AutoEncoder with Logistic Regression (Implemented as Jupyter notebook)
2. AutoEncoder with LSTM (Implemented as Jupyter notebook)
3. Variational Autoencoder (VAE) (Implemented as python script)

## Prerequisites

- Python 3.x
- Jupyter Notebook
- PyTorch
- Transformers library (for CodeBERT and CodeT5)
- Tensorflow (for VAE)
- Other dependencies as mentioned in the notebooks

## Usage

### For Jupyter Notebookes

1. Clone or download this repository to your local machine.
2. Open Jupyter Notebook.
3. Navigate to the directory where you cloned or downloaded the repository.
4. Open the desired notebook 
5. Run all cells. 

### For Python Scripts
1. Go to the corresponding file : DL-Models\smell-detection-dl-win\Py-Scripts\program\dl_models\VAE_xx.py (where xx denotes the smell). 
2. Change the parameters: `TOKENIZER_OUT_PATH` represents the output of the tokenizer. `OUT_FOLDER` represents where the output of the program will be stored. 
3. Run the python command: py DL-Models\smell-detection-dl-win\Py-Scripts\program\dl_models\VAE_xx.py (where xx denotes the smell)

## Generated Weights
1. The weight files (.m5) files will be generated at the location where the commands are run from. These wieghts can then be used in the further steps

