package com.backend.wallet.portfolio.domain.model.queries;

import java.util.Date;

public record GetPortfoliosByDateRangeQuery(Date startDate, Date endDate) {
}