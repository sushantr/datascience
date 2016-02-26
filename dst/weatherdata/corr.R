corr <- function(directory, threshold = 0) {
  
  complete_table <- complete(directory, 1:332)
  nobs <- complete_table$nobs
  # find the valid ids
  ids <- complete_table$id[nobs > threshold]
  
  fnames <- paste(directory , "/", formatC(1:length(ids), width=3, flag="0"), sep="", se=".csv")
  df_merged <- c()
  
  for(i in ids) {
    df <- read.csv(get_file_name(i), header=T, sep=",")
    
    corr_df <- round(cor(df$sulfate, df$nitrate, use="complete.obs"), 5)

    df_merged <- c(df_merged, corr_df)
    
  }
  
  result <- df_merged
  return(result)
}

get_file_name <- function(findex){
  
  fname <- paste("specdata" , "/", formatC(findex, width=3, flag="0"), sep="", se=".csv")
  
  return <- fname
  
  
}


# source("corr.R")
# source("complete.R")
# cr <- corr("specdata", 150)
# head(cr)
# ## [1] -0.01896 -0.14051 -0.04390 -0.06816 -0.12351 -0.07589
# summary(cr)
# ##    Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
# ## -0.2110 -0.0500  0.0946  0.1250  0.2680  0.7630
# cr <- corr("specdata", 400)
# head(cr)
# ## [1] -0.01896 -0.04390 -0.06816 -0.07589  0.76313 -0.15783
# summary(cr)
# ##    Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
# ## -0.1760 -0.0311  0.1000  0.1400  0.2680  0.7630
# cr <- corr("specdata", 5000)
# summary(cr)
# ##    Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
# ## 
# length(cr)
# ## [1] 0
# cr <- corr("specdata")
# summary(cr)
# ##    Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
# ## -1.0000 -0.0528  0.1070  0.1370  0.2780  1.0000
# length(cr)
# ## [1] 323