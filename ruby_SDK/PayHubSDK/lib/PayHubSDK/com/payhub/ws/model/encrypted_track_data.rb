class EncryptedTrackData
  include JsonSerializer
  ATTRS=[:encrypted_track,:swiper_band,:swiper_model]
  attr_accessor *ATTRS
  @encrypted_track=""
  @swiper_band="IDTECH"
  @swiper_model="UNIMAGII"

  def initialize

  end
end