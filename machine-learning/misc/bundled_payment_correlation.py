# BPCE use case


import pandas as pd
import numpy as np
from scipy import stats
import matplotlib.pyplot as plt
from sklearn import linear_model



def fit():
	print "fitting data"

	devices  = [1,2,3,4,5,6,7,2,3,4,5,6,7]

	outcomes = [2,3,5,5,7,7,9,3,4,5,6,7,9]

	df1 = pd.DataFrame(outcomes, index=range(0,len(outcomes)), columns=['outcome'])

	df2 = pd.DataFrame(devices, index=range(0,len(devices)), columns=['device'])

	frames = [df1, df2]

 	#df_main = pd.concat(frames)

 	df_main = pd.concat(frames, axis=1, join='outer', join_axes=None, ignore_index=False,
       keys=None, levels=None, names=None, verify_integrity=False)


 	# Split the data into training/testing sets
	X_train = df_main[:-5]['device']
	X_train = X_train.reshape(len(X_train),1)
	X_test = df_main[-5:]['device']
	X_test = X_test.reshape(len(X_test),1)

	# Split the targets into training/testing sets
	y_train = df_main[:-5]['outcome']
	y_train = y_train.reshape(len(y_train),1)
	y_test = df_main[-5:]['outcome']
	y_test = y_test.reshape(len(y_test),1)
	
	
	# Create linear regression object
	regr = linear_model.LinearRegression()

	print len(X_test)

	print len(y_test)


	# Train the model using the training sets
	regr.fit(X_train, y_train)

	# The coefficients
	print('Coefficients: \n', regr.coef_)
	# The mean square error
	print("Residual sum of squares: %.2f"
	      % np.mean((regr.predict(X_test) - y_test) ** 2))
	# Explained variance score: 1 is perfect prediction
	print('Variance score: %.2f' % regr.score(X_test, y_test))

	# Plot outputs
	plt.scatter(X_test, y_test,  color='black')
	plt.plot(X_test, regr.predict(X_test), color='blue',
	         linewidth=3)

	plt.xticks(())
	plt.yticks(())

	plt.show()




	#print df_main

	#slope, intercept, r_value, p_value, std_err = stats.linregress(devices,outcomes)

	#print "slope, intercept, r_value, p_value, std_err ",slope, intercept, r_value, p_value, std_err 

	#print "r-squared:", r_value**2

	#plot_me(devices, outcomes)



def plot_me(x,y):
	plt.plot(x, y)
	plt.show()

if __name__=="__main__":
    print "BPCE use case"

    fit()