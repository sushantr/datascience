import pandas as pd
import numpy as np


def norm_portfolio():
	d = {"SPY" : [68.80, 68.70, 78.28, 79.67, 81.01],
	    "XOM" : [74.48, 74.47, 73.26, 71.39, 85.13],	
	    "HNZ" : [33.95, 33.82, 33.38, 32.59, 31.99],
	    "AAPL": [70.36, 74.18, 72.62, 70.62, 72.30],	    
	    "GLD" : [86.23, 84.48, 85.13, 82.75, 84.46]}

	df = pd.DataFrame(d)

	normed = df/df.ix[0]
	normed['AAPL'] = np.nan
	normed.fillna(value='0')
	print normed[0:2]


if __name__ == "__main__":
    norm_portfolio()