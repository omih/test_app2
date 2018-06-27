package com.zcmx.bit.data.scheduler;

import io.reactivex.Scheduler;

public interface SchedulerProvider {

    Scheduler io();

    Scheduler ui();
}
