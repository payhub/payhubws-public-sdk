using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace PayHubSDK.com.payhub.ws.model
{
    [DataContract]
    public class Schedule
    {
        [DataMember]
        private string schedule_type;
        public string Schedule_type
        {
            get { return this.schedule_type; }
            set { if (value != null)this.schedule_type = value; }
        }
        [DataMember]
        private int bill_generation_interval;
        public int Bill_generation_interval
        {
            get { return this.bill_generation_interval; }
            set { this.bill_generation_interval = value; }
        }
        [DataMember]
        private ScheduleSartAndEnd schedule_start_and_end;
        public ScheduleSartAndEnd Schedule_start_and_end
        {
            get { return this.schedule_start_and_end; }
            set { if (value != null)this.schedule_start_and_end = value; }
        }
        [DataMember]
        private MontlySchedule monthly_schedule;
        public MontlySchedule Monthly_schedule
        {
            get { return this.monthly_schedule; }
            set { if (value != null)this.monthly_schedule = value; }
        }
        [DataMember]
        private SpecificDatesSchedule specific_dates_schedule;
        public SpecificDatesSchedule Specific_dates_schedule
        {
            get { return this.specific_dates_schedule; }
            set { if (value != null)this.specific_dates_schedule = value; }
        }
        [DataMember]
        private WeeklySchedule weekly_schedule;
        public WeeklySchedule Weekly_schedule
        {
            get { return this.weekly_schedule; }
            set { if (value != null)this.weekly_schedule = value; }
        }
        [DataMember]
        private YearlySchedule yearly_schedule;
        public YearlySchedule Yearly_schedule
        {
            get { return this.yearly_schedule; }
            set { if (value != null)this.yearly_schedule = value; }
        }

        public Schedule(string schedule_type)
        {
            this.schedule_type = schedule_type;
        }
        public Schedule() { }
    }
}
