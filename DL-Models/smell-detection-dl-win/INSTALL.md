# Installing the Deep-Learning Models
This document provides installation instructions for the models used in the experiments. 

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
