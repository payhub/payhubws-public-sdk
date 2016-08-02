class Batch
  include JsonSerializer
  ATTRS=[:terminalId,:MSG,:orgnazationId,:batchId,:TRN_RESPONSE,:errors]
  BATCH_LINK = "batch/"
  attr_accessor *ATTRS
  def initialize

  end

end

class TRN_RESPONSE
  include JsonSerializer
  ATTRS=[:RESPONSE_TEXT,:RESPONSE_CODE,:TRN_DATE_TIME]
  attr_accessor *ATTRS
  def initialize

  end
end