# BPCE use case


import pandas as pd
import numpy as np
from scipy import stats
import matplotlib.pyplot as plt



def fit():
	print "fitting data"

	devices = [1,2,3,4,5,6,7,2,3,4,5,6,7]

	outcomes = [1,3,1,5,6,7,2,1,4,4,6,4,3]

	df1 = pd.DataFrame(outcomes, index=range(0,len(outcomes)), columns=['outcome'])

	df2 = pd.DataFrame(devices, index=range(0,len(devices)), columns=['device'])

	frames = [df1, df2]

 	#df_main = pd.concat(frames)

 	df_main = pd.concat(frames, axis=1, join='outer', join_axes=None, ignore_index=False,
       keys=None, levels=None, names=None, verify_integrity=False)
	
	print df_main

	slope, intercept, r_value, p_value, std_err = stats.linregress(devices,outcomes)

	print "slope, intercept, r_value, p_value, std_err ",slope, intercept, r_value, p_value, std_err 

	print "r-squared:", r_value**2

	plot_me(devices, outcomes)



def plot_me(x,y):
	plt.plot(x, y)
	plt.show()

if __name__=="__main__":
    print "BPCE use case"

    fit()