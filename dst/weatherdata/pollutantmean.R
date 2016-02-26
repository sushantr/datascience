

pollutantmean <- function(directory, pollutant, id = 1: 322){
  
  fnames <- paste(directory , "/", formatC(id, width=3, flag="0"), sep="", se=".csv")
  df_merged <- c()
  
  for(fname in fnames) {
    df <- read.csv(fname, header = TRUE)
    df_no_na <- df[!is.na(df[, pollutant]), pollutant]

    df_merged <- c(df_merged, df_no_na)
  }
  
  result <- mean(df_merged)
  return(round(result, 3)) 
  
}



#source("pollutantmean.R")
#pollutantmean("specdata", "sulfate", 1:10)
# ## [1] 4.064
# pollutantmean("specdata", "nitrate", 70:72)
# ## [1] 1.706
# pollutantmean("specdata", "nitrate", 23)
# ## [1] 1.281


