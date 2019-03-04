#!/bin/sh
##SBATCH --partition=compute
##SBATCH --job-name=hadoopsort
#SBATCH --nodes=1
##SBATCH --ntasks=1
##SBATCH --exclude=hadoop-g,hadoop-i,hadoop-c,hadoop-a,hadoop-b
##SBATCH --time=0:20:00
##SBATCH --wait-all-node=1
#SBATCH --output=SparkSort80GB.log
##START_TIME=$SECONDS
spark-submit --class SparkSort --master yarn --deploy-mode client --driver-memory 1g --executor-memory 1g --executor-cores 4 --num-executors 4 SparkSort.jar /input/data-80GB /user/yxu81/output-spark
##ELAPSED_TIME=$(($SECONDS - $START_TIME))
##echo "The total time for hadoopsort is $ELAPSED_TIME s"
hadoop jar /opt/hadoop-2.9.0/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.9.0.jar teravalidate /user/yxu81/output-spark /user/yxu81/report-spark
hadoop fs -get /user/yxu81/report-spark/part-r-00000
