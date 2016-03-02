import pandas as pd
import numpy as np


def norm_portfolio():
	d = {"SPY" : [86.80, 86.70, 87.28, 84.67, 85.01],
	    "AAPL": [90.36, 94.18, 92.62, 90.62, 92.30],
	    "HNZ" : [33.95, 33.82, 33.38, 32.59, 31.99],
	    "XOM" : [74.48, 74.47, 73.26, 71.39, 85.13],
	    "GLD" : [86.23, 84.48, 85.13, 82.75, 84.46]}

	df = pd.DataFrame(d)

	normed = df/df.ix[0]
	normed['AAPL'] = np.nan
	normed.fillna(value='0')
	print normed[0:2]


if __name__ == "__main__":
    norm_portfolio()