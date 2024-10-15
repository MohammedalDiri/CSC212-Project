## Stock Market Data Analysis Project
# Introduction
This project explores the intersection of finance and data structures, applying programming skills to analyze historical stock market data. The goal is to gain practical experience by manipulating, analyzing, and deriving insights from real-world financial data.

# Dataset Overview
The dataset contains historical stock data for various companies, including key metrics such as the open, high, low, and close prices, as well as the trading volume for each day. Each company's stock history is stored in a separate CSV file, named according to the company's code.

# Sample Data
For example, the stock data for Google (GOOGL) includes:

Date	Open	High	Low	Close	Volume
2004-08-19	2.50	2.60	2.40	2.51	893181924
2004-08-20	2.53	2.73	2.52	2.71	456686856
2004-08-23	2.77	2.84	2.73	2.74	365122512
2004-08-24	2.78	2.79	2.59	2.62	304946748
These records provide essential data points for analyzing stock trends and performance.

# Data Files
The dataset is divided into two folders:

Real Data: Contains actual historical stock data.
Example Data: Provides simplified data for debugging and testing code.
# Terminology
Understanding the following terms will help in analyzing the stock data effectively:

-Data Point: A single piece of data recorded at a specific time, such as the open, high, low, close prices, or volume for a particular day.

-Time Series: A sequence of data points representing the same information over time, like daily closing prices of a stock.

-Moving Average: A calculation used to smooth out price data by averaging subsets of the dataset over a specified period, helping to identify trends.

Example: 3-Day Moving Average
Given daily closing prices over five days:

Day 1: $10
Day 2: $12
Day 3: $11
Day 4: $13
Day 5: $14
The 3-day moving average is calculated as follows:

Days 1-3: (10 + 12 + 11) / 3 = $11
Days 2-4: (12 + 11 + 13) / 3 = $12
Days 3-5: (11 + 13 + 14) / 3 = $12.67
Resulting in the following time series:

Day 3: $11

Day 4: $12

Day 5: $12.67

-Price Increase: The difference between the closing prices on two consecutive days. The Single Day Price Increase (SDPI) is the difference between the closing and opening prices on the same day.

-Stock Performance: An evaluation of how a stock's price changes over time, often measured by the relative change in price.

Example: Stock Performance
Given the closing prices:

Day 1: $10
Day 2: $12
Day 3: $11
Day 4: $13
Day 5: $14
The performance between Day 2 and Day 4 is calculated as:

Performance = 13-12/12 = 0.083 or 8.3%



# Getting Started
Clone the repository and explore the provided data to start analyzing stock market trends and performance.
