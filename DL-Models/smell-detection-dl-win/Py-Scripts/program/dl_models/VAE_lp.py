import os
import autoencoder

TOKENIZER_OUT_PATH = r"C:\Users\author\Documents\thesis\pythonNotebook\tokenizerOut"
#TOKENIZER_OUT_PATH = "/home/author/TagCoder/tokenizer_out_java/"
OUT_FOLDER = r"C:\Users\author\Documents\thesis\pythonNotebook"
# TOKENIZER_OUT_PATH = r"..\..\data\tokenizer_out"
# OUT_FOLDER = r"..\results\rq1\raw"

smell_list = ['LongMethod']
DIM = "1d"

for smell in smell_list:
    data_path = os.path.join(TOKENIZER_OUT_PATH, smell, DIM)
    autoencoder.main_lstm(smell, data_path,OUT_FOLDER, skip_iter=-1)

