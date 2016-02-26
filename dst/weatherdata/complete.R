complete <- function(directory, id = 1:332) {
 
  fnames <- paste(directory , "/", formatC(id, width=3, flag="0"), sep="", se=".csv")
  df_merged <- c()
  
  for(fname in fnames) {
    df <- read.csv(fname, header = TRUE)
    df_sum <- sum(complete.cases(df))
    
    df_merged <- c(df_merged, df_sum)
    
  }
  
  result <- data.frame(id = id, nobs = df_merged)
  return(result)
  

}


# source("complete.R")
# complete("specdata", 1)
# ##   id nobs
# ## 1  1  117
# complete("specdata", c(2, 4, 8, 10, 12))
# ##   id nobs
# ## 1  2 1041
# ## 2  4  474
# ## 3  8  192
# ## 4 10  148
# ## 5 12   96
# complete("specdata", 30:25)
# ##   id nobs
# ## 1 30  932
# ## 2 29  711
# ## 3 28  475
# ## 4 27  338
# ## 5 26  586
# ## 6 25  463
# complete("specdata", 3)
# ##   id nobs
# ## 1  3  243