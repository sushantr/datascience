
dirpath <- "data"


if(!file.exists(dirpath)) {
  dir.create(dirpath)
}


fileURL <- "https://data.baltimorecity.gov/api/views/dz54-2aru/rows.csv?accessType=DOWNLOAD"

download.file(fileURL, destfile = "data/cameras.csv", method = "curl")

list.files(dirpath)

dateDownloaded <- date()

