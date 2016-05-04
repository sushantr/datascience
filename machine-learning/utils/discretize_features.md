

```python
import pandas as pd
```


```python
import numpy as np
```


```python
instance_count = 1000 # number of instances
dims = 3
features = ['X1','X2']

    
df_train = pd.DataFrame(np.random.randn(instance_count, dims), columns=['X1','X2', 'Y'], index=np.arange(instance_count))

```


```python
df_train.head()
```




<div>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>X1</th>
      <th>X2</th>
      <th>Y</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>0.920336</td>
      <td>-1.373443</td>
      <td>-0.504973</td>
    </tr>
    <tr>
      <th>1</th>
      <td>-0.319953</td>
      <td>-0.149405</td>
      <td>1.855625</td>
    </tr>
    <tr>
      <th>2</th>
      <td>1.482499</td>
      <td>-0.500651</td>
      <td>0.998920</td>
    </tr>
    <tr>
      <th>3</th>
      <td>1.063249</td>
      <td>1.599405</td>
      <td>0.885618</td>
    </tr>
    <tr>
      <th>4</th>
      <td>-1.187006</td>
      <td>-1.178587</td>
      <td>0.451835</td>
    </tr>
  </tbody>
</table>
</div>



It's probably faster and easier to use numpy.digitize():


```python
bins = np.linspace(0, 1, 10)
```


```python
digitized = np.digitize(df_train, bins)
```


```python
digitized[0:10]
```




    array([[ 9,  0,  0],
           [ 0,  0, 10],
           [10,  0,  9],
           [10, 10,  8],
           [ 0,  0,  5],
           [10, 10,  8],
           [10,  5,  1],
           [ 0,  0,  0],
           [ 3,  6,  0],
           [ 0,  0,  4]])




```python
bin_means = [df_train[digitized == i].mean() for i in range(1, len(bins))]
```


```python
bin_means[0:2]
```




    array([ 0.05897551,  0.17265429])



An alternative to this is to use numpy.histogram():


```python
bin_means = (np.histogram(df_train, bins, weights=df_train)[0] /
             np.histogram(df_train, bins)[0])
```


```python
bin_means
```




    array([ 0.05897551,  0.17265429,  0.28207422,  0.38843034,  0.49765604,
            0.61197011,  0.72088121,  0.83186996,  0.94432476])




```python

```
